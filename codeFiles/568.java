  @Query(&quot;select event.id from EventLogDb event where (key(event.metaProperties) = 'messageUUID' and :message in VALUE(event.metaProperties))&quot;)  Slice<EventLogDb> findAllByMessage(          String message, Pageable pageable);ERROR: more than one row returned by a subquery used as an expression