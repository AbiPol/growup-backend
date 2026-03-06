package com.growup.backend.domain.port.in;

import com.growup.backend.model.AnalyticsSummary;
import com.growup.backend.model.CoursePerformance;
import com.growup.backend.model.DashboardStats;
import com.growup.backend.model.RevenueData;

import java.util.List;
import java.util.UUID;

/**
 * Puerto de Entrada para los casos de uso del Dashboard.
 */
public interface DashboardInPort {
    /**
     * Obtiene las estadísticas generales del dashboard para un instructor
     * específico.
     * 
     * @param instructorId Identificador del instructor.
     * @return Estadísticas del dashboard.
     */
    DashboardStats getDashboardStats(UUID instructorId);

    /**
     * Obtiene un resumen completo de analíticas para un instructor.
     * 
     * @param instructorId Identificador del instructor.
     * @return Resumen de analíticas.
     */
    AnalyticsSummary getAnalyticsSummary(UUID instructorId);

    /**
     * Obtiene la tendencia de ingresos mensuales para un instructor.
     * 
     * @param instructorId Identificador del instructor.
     * @param months       Número de meses atrás (opcional).
     * @return Lista de datos de ingresos por mes.
     */
    List<RevenueData> getRevenueTrends(UUID instructorId, Integer months);

    /**
     * Obtiene el rendimiento detallado por curso para un instructor.
     * 
     * @param instructorId Identificador del instructor.
     * @return Lista de rendimiento por curso.
     */
    List<CoursePerformance> getCoursePerformance(UUID instructorId);
}
