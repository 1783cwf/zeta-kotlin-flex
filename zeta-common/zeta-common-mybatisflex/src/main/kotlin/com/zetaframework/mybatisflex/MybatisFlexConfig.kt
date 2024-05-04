package com.zetaframework.mybatisflex

import com.mybatisflex.annotation.KeyType
import com.mybatisflex.core.FlexGlobalConfig
import com.mybatisflex.core.FlexGlobalConfig.KeyConfig
import com.mybatisflex.core.audit.AuditManager
import com.mybatisflex.core.keygen.KeyGenerators
import com.mybatisflex.core.logicdelete.LogicDeleteProcessor
import com.mybatisflex.core.logicdelete.impl.BooleanLogicDeleteProcessor
import com.mybatisflex.core.query.QueryColumnBehavior
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer
import com.mybatisflex.spring.boot.MybatisFlexProperties
import com.tangzc.autotable.core.AutoTableOrmFrameAdapter
import com.zetaframework.mybatisflex.adapter.MybatisFlexAutoTableAdapter
import com.zetaframework.mybatisflex.entity.BaseEntity
import com.zetaframework.mybatisflex.listener.EntityInsertListener
import com.zetaframework.mybatisflex.listener.EntityUpdateListener
import com.zetaframework.mybatisflex.properties.DatabaseProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * @author caoweifeng
 * @date 2024年01月29日 22:17
 * @email weistuday@gmail.com
 * @description:
 */
@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(DatabaseProperties::class)
class MybatisFlexConfig(
    private val databaseProperties: DatabaseProperties,
) : MyBatisFlexCustomizer {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    init {
        QueryColumnBehavior.setIgnoreFunction(QueryColumnBehavior.IGNORE_BLANK)
        QueryColumnBehavior.setSmartConvertInToEquals(true)
    }

    override fun customize(globalConfig: FlexGlobalConfig?) {
        // 注册全局数据填充监听器
        globalConfig?.registerInsertListener(EntityInsertListener(), BaseEntity::class.java)
        globalConfig?.registerUpdateListener(EntityUpdateListener(), BaseEntity::class.java)

        // 设置主键生成策略
        val keyConfig = KeyConfig()
        keyConfig.keyType = KeyType.Generator
        keyConfig.value = KeyGenerators.flexId
        globalConfig?.keyConfig = keyConfig
        // 是否开启SQL审计
        AuditManager.setAuditEnable(databaseProperties.auditEnable)

        if (databaseProperties.isPrintSql) {
            logger.info("全局打印SQL已启用")
            // 开启sql打印默认会开启sql审计
            AuditManager.setAuditEnable(true)
            AuditManager.setMessageCollector {
                logger.info(
                    """

                    ==============  Sql Start  ==============
                    Execute SQL : ${it.fullSql}
                    Execute Time: ${it.elapsedTime}ms
                    ==============  Sql  End   ==============

                    """.trimIndent(),
                )
            }
        }
    }

    @Bean
    @ConditionalOnExpression(value = "#{'true'.equals(environment['zeta.mybatis-flex.logic-delete'])}")
    fun logicDeleteProcessor(): LogicDeleteProcessor {
        logger.info("逻辑删除已启用")
        return BooleanLogicDeleteProcessor()
    }

    @Bean
    fun mybatisFlexAdapter(mybatisFlexProperties: MybatisFlexProperties): AutoTableOrmFrameAdapter {
        return MybatisFlexAutoTableAdapter(mybatisFlexProperties)
    }
}
