myEntityRepository.save(MyEntity.builder()    .id(currentIdNumber.incrementAndGet())    //.... defining other fields    .build());