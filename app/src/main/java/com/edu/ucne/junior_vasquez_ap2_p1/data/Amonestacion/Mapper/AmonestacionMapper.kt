package com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.Mapper

import com.edu.ucne.junior_vasquez_ap2_p1.data.Amonestacion.local.AmonestacionEntity
import com.edu.ucne.junior_vasquez_ap2_p1.domain.Borrame.Model.Amonestacion

fun AmonestacionEntity.toDomain() : Amonestacion = Amonestacion(
    amonestacionId = amonestacionId,
    nombres = nombres,
    razon = razon,
    monto = monto

)

fun Amonestacion.toEntity() : AmonestacionEntity = AmonestacionEntity(

    amonestacionId = amonestacionId,
    nombres = nombres,
    razon = razon,
    monto = monto
)