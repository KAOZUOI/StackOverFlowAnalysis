{  &quot;name&quot;: &quot;mysql-jdbc&quot;,  &quot;config&quot;: {    &quot;connector.class&quot; : &quot;io.confluent.connect.jdbc.JdbcSourceConnector&quot;,    &quot;connection.url&quot;  : &quot;jdbc:mysql://mysqldb:3306/silicon&quot;,    &quot;connection.user&quot; : &quot;root&quot;,    &quot;connection.password&quot; : &quot;root&quot;,    &quot;mode&quot;            : &quot;incrementing&quot;,    &quot;incrementing.column.name&quot;: &quot;id&quot;,    &quot;query&quot;: &quot;select * from (select * from credit_lines where id=2) test&quot;,    &quot;topic.prefix&quot;    : &quot;JDBC.test_db_test&quot;,    &quot;validate.non.null&quot;       : &quot;false&quot;,    &quot;poll.interval.ms&quot;        : &quot;1000&quot;  }}