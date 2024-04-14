package com.zetaframework.base.controller

import com.mybatisflex.core.service.IService
import com.zetaframework.base.controller.curd.DeleteController
import com.zetaframework.base.controller.curd.QueryController
import com.zetaframework.base.controller.curd.SaveController
import com.zetaframework.base.controller.curd.UpdateController
import java.lang.reflect.ParameterizedType

/**
 * 完整增删改查 BaseController
 *
 * 实现了Query、Save、Update、Delete、BatchDelete
 *
 * @param <S>           Service
 * @param <Id>          主键字段类型
 * @param <BaseEntity>      实体
 * @param <QueryParam>  查询参数
 * @param <SaveDTO>     保存对象
 * @param <UpdateDTO>   修改对象
 * @author gcc
 */
abstract class SuperController<S : IService<Entity>, Entity, QueryParam, SaveDTO, UpdateDTO> :
    SuperSimpleController<S, Entity>(),
    QueryController<Entity, QueryParam>,
    SaveController<Entity, SaveDTO>,
    UpdateController<Entity, UpdateDTO>,
    DeleteController<Entity> {
    /**
     * 获取实体类型
     *
     * @return Class<BaseEntity>
     */
    override fun getEntityClass(): Class<Entity> {
        if (super.clazz == null) {
            // 获取当前类的第三个泛型的值(下标从0开始)。 即Entity的值
            super.clazz =
                (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<Entity>
        }
        return super.clazz!!
    }
}
