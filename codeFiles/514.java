TypeMapping mapping = ...;CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder()         .index(index)         .mappings(mapping)         .build();