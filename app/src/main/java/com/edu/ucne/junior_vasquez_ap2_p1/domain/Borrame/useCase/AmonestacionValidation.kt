package com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.useCase

data class AmonestacionValidation(
    val isValid : Boolean,
    val error : String? = null
)

fun validateNombre(nombre : String) : AmonestacionValidation
{
    return when{
        nombre.isBlank() -> AmonestacionValidation(false,"El o Los nombre no debe ir vacio")
        nombre.length < 3 -> AmonestacionValidation(false,"El o Los nombre debe ser mas largo")
        else -> AmonestacionValidation(true)
    }

}

fun validateRazon(razon: String) : AmonestacionValidation
{
    return when{
        razon.isBlank() -> AmonestacionValidation(false,"La Razon o Motivo no debe ir vacio")
        else -> AmonestacionValidation(true)
    }
}

fun validateMonto(monto:Double ) : AmonestacionValidation
{

    return when{
        monto <= 0.0 -> AmonestacionValidation(false,"El Monto debe ser mayor a 0")
        monto.toString().isNullOrEmpty() -> AmonestacionValidation(false,"Debe haber algo en el Monto")
        else -> AmonestacionValidation(true)
    }

}