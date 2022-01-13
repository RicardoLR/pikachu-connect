package com.rich.repository

import com.rich.entity.TraceModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TraceModelRepo extends JpaRepository<TraceModel, Integer> {
}
