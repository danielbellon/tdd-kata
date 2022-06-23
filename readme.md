# TDD Dojo

<!-- TABLE OF HEADER -->
[![Java][skill-java-shield]][skill-java-url]
[![Lombok][skill-lombok-shield]][skill-lombok-url]
[![Gradle][skill-gradle-shield]][skill-gradle-url]

[![Commits][documentation-commit-shield]][documentation-commit-url]

<!-- ABOUT THE PROJECT -->
## About The Project

`tdd-dojo` is a sandbox project made with learning and practice purposes regarding to Test Driven Development 

<!-- GETTING STARTED -->
## Bowling Game

The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

### Requirements

Write a class Game that has two methods

1. `void roll(int)` is called each time the player rolls a ball. The argument is the number of pins knocked down.
2. `int score()` returns the total score for that game.

### Constraints

#### Baby Steps

##### Rules
1. Setup a git repository (or use another SCM that supports resets)
2. Setup a timer for 2 minutes interval when you start
3. Write exactly one test
   1. If the timer rings and the test is red then revert and start over
   2. If you finish your test earlier: no problem, reset the timer and continue
4. Restart timer
5. Go to 3.
   
##### Hints
- Most pairs need to reset at least once
- It is absolutely OK to spend iterations to do only refactorings
- Feel free to discuss whatever is needed in between cycles
- The most important part is to have green tests. Your code base must never be red for more than two minutes

### Prerequisites

List things you need to use the software and how to install them.
* [Java 17](https://www.oracle.com/java/technologies/downloads/#jdk17-linux)
* [Docker](https://docs.docker.com/engine/install/)
* [Docker Compose](https://docs.docker.com/compose/install/)
* [Gradle](https://gradle.org/install/)

**Note:** The Code provides his own version of [Gradle 7.4](https://gradle.org/install/) ``./gradlew``, But, If you want
to use the version installed in your machine, you have to run tasks using ``gradle``

### Installation

#### Build artifact

**Using Java 17 as default JDK:**
If you don't know which JDK is running in your machine, check it using:

```shell
sudo update-alternatives --config java
```

**Now, you can build Application running:**

```shell
./gradlew build
```

**You can find your newly packaged JAR file in the lib/build/libs directory with the name lib.jar. Verify that the archive is valid by running the following command::**

```shell
$jar tf lib/build/libs/lib.jar

META-INF/
META-INF/MANIFEST.MF
lib/
lib/Library.class
```

**Using Java 17 explicitly:**

```shell
./gradlew build -Dorg.gradle.java.home="/usr/lib/jvm/java-17-openjdk-amd64"
```

<!-- USAGE EXAMPLES -->

#### Run unit tests

```shell
./gradlew test
```

## Usage
To be defined :trollface:

## Contributing to DTP Commons

We want to make contributing to this project as easy and transparent as possible.

### Pull Requests

The branch strategy we use is gitflow. Giflow is an alternative Git branching model that involves the use of feature branches and multiple primary branches. More information [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow#:~:text=Gitflow%20is%20a%20legacy%20Git,software%20development%20and%20DevOps%20practices.)

### Conventional commits

Our repositories follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/#summary) specification.

Commit should have a title that follows the specification.You can also use this cheatsheet if you want:

- `fix:` prefix in the title indicates that PR is a bug fix and PATCH release must be triggered.
- `feat:` prefix in the title indicates that PR is a feature and MINOR release must be triggered.
- `docs:` prefix in the title indicates that PR is only related to the documentation and there is no need to trigger release.
- `chore:` prefix in the title indicates that PR is only related to cleanup in the project and there is no need to trigger release.
- `test:` prefix in the title indicates that PR is only related to tests and there is no need to trigger release.
- `refactor:` prefix in the title indicates that PR is only related to refactoring and there is no need to trigger release.

What about MAJOR release? just add `!` to the prefix, like `fix!: ` or `refactor!: `

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://shields.io/ -->
[skill-java-shield]: https://img.shields.io/badge/JAVA-17-blue
[skill-java-url]: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
[skill-lombok-shield]: https://img.shields.io/badge/lombok-1.18.22-blue
[skill-lombok-url]: https://projectlombok.org/
[skill-gradle-shield]: https://img.shields.io/badge/gradle-7.4%20-blue
[skill-gradle-url]: https://gradle.org/install/
[documentation-commit-shield]: https://img.shields.io/badge/Conventional%20Commits-1.0.0--beta.2-orange
[documentation-commit-url]: https://www.conventionalcommits.org/es/v1.0.0-beta.2/




