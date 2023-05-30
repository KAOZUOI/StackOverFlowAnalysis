public int getCountReprintHistory(String request_date, String statement_type, String option_type, String cust_no) throws SQLException {    PreparedStatement stmt;    boolean unconstrained = request_date.equals(&quot;&quot;) && statement_type.equals(&quot;&quot;) && option_type.equals(&quot;&quot;) && cust_no.equals(&quot;&quot;);    if ( unconstrained ) {        stmt = cnt.prepareStatement(                &quot;SELECT COUNT(REPRINTLOG_DATE) FROM TBL_REPRINT_HISTORY2 &quot;                + &quot;ORDER BY REPRINTLOG_JOBID DESC &quot;);    } else {                            stmt = cnt.prepareStatement(                &quot;SELECT COUNT(REPRINTLOG_DATE) FROM TBL_REPRINT_HISTORY2 &quot;                + &quot;WHERE TO_CHAR(REPRINTLOG_DATE,'dd/mm/yyyy') LIKE '%' || ? || '%' &quot;                + &quot;AND REPRINTLOG_STATEMENT_TYPE LIKE '%' || ? || '%' &quot;                + &quot;AND REPRINTLOG_OPTION_TYPE LIKE '%' || ? || '%' &quot;                + &quot;AND REPRINTLOG_CUSTOMER_NO LIKE '%' || ? || '%' &quot;                + &quot;ORDER BY REPRINTLOG_JOBID DESC &quot;);    }    try {        if (!unconstrained) {            stmt.setString(1, request_date);            stmt.setString(2, statement_type);            stmt.setString(3, option_type);            stmt.setString(4, cust_no);        }        try (ResultSet rs = stmt.executeQuery()) {            rs.next();            return rs.getInt(1);        }    } finally {        stmt.close();    }}