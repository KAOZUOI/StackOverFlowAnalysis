    Map.of(predicate1, action1, ... predicateN, actionN)    .entrySet().stream()    .filter(e -> e.getKey()).findAny()    .ifPresentOrElseThrow().getValue();