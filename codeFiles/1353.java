app.version=1.0server.port=8080spring.redis.host=localhostspring.redis.port=6379redis.connection.pool.max.total=50redis.connection.pool.idle.total=50#Actuator endpoints configurationmanagement.endpoints.web.base-path=/management.endpoint.info.enabled=truemanagement.endpoint.health.enabled=truemanagement.endpoints.web.path-mapping.health=statusmanagement.endpoints.web.exposure.include=health,infomanagement.endpoint.health.show-details=alwayslogging.level.root=DEBUGlogging.pattern.console=%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %X{X-CorrelationId} %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}logging.pattern.file=%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %X{X-CorrelationId} %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}server.tomcat.basedir=/var/tmp/tomcatspring.main.allow-circular-references=truespring.main.allow-bean-definition-overriding=truespring.main.lazy-initialization=true