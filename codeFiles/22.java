TCSession session = (TCSession) AIFUtility.getDefaultSession();DataManagementService dmservice = DataManagementService.getService(session);CreateInput irev = new CreateInput();irev.boName = &quot;ItemRevision&quot;;irev.stringProps.put( &quot;object_desc&quot;, &quot;object_desc&quot; );irev.stringProps.put( &quot;object_name&quot;, &quot;object_name_test&quot; );irev.stringProps.put( &quot;item_revision_id&quot;, &quot;01&quot; );CreateIn[] ci = new CreateIn[1];ci[0] = new CreateIn();ci[0].data = irev;ci[0].clientId = Integer.valueOf(1).toString();CreateResponse cr = dmservice.createObjects(ci);