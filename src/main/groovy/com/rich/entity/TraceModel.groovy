package com.rich.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "app_trace")
class TraceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column
    String ip

    @Column
    LocalDateTime date

    @Column
    String method
}
