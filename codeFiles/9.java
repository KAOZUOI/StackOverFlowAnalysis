package com.dhre.realconnect.notificationService.notificationRepository;import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import org.springframework.data.jpa.repository.QueryHints;import org.springframework.stereotype.Repository;import com.dhre.realconnect.notificationService.notificationEntities.Events;import javax.persistence.QueryHint;/** * Repository for Event table in Notification database * @author M1081522 * */@Repositorypublic interface EventRepository extends JpaRepository<Events, Integer>{   @Query(value = &quot;SELECT * FROM Events WHERE EventCode=:eventCode&quot;, nativeQuery = true)   @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = &quot;true&quot;))   Optional<Events> getByEventCode(String eventCode);}