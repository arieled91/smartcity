package ar.edu.usal.common

import ar.edu.usal.smartcity.model.city.ViolationType
import kotlin.reflect.KClass

class EnumMapException(clazz: KClass<*>) : RuntimeException("Cannot map enum "+clazz.simpleName)