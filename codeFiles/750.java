.├── app│   ├── build.gradle.kts│   └── src│       └── main│           └── java│               └── com/example/app/App.java├── plugin│   ├── build.gradle.kts│   └── src│       └── main│           └── java│               └── com/example/plugin/Animal.java├── plugin-cat│   ├── build.gradle.kts│   └── src│       └── main│           ├── java│           │   └── com/example/cat/Cat.java│           └── resources│               └── META-INF/services/com.example.plugin.Animal├── plugin-dog│   ├── build.gradle.kts│   └── src│       └── main│           ├── java│           │   └── com/example/dog/Dog.java│           └── resources│               └── META-INF/services/com.example.plugin.Animal└── settings.gradle.kts