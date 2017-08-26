package ar.edu.usal.common

import kotlin.reflect.KClass

class EnumMapException(clazz: KClass<*>) : RuntimeException("Cannot map enum " + clazz.simpleName)