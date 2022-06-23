# VARIABLES
APPNAME := dtp-commons
APPVERSION := 1.0.0
IMAGE_NAME := name
IMAGE_VERSION := 1.0.0
SOURCE_PATH := pom.xml
SKIP_TESTS := $(SKIP_TESTS)

###########
##DON'T CHANGE BELOW THIS LINE UNLESS NEEDED
##KEEP IN MIND THAT MAKEFILE WILL SHOW ERRORS UNLESS THE LINE IS STARTED WITH A TAB. IF YOU SEE ERRORS
#INDICATING A MISSING SEPARATOR, YOU PROBABLY HAVE SPACES INSTEAD OF TAB

# HELP
.PHONY: help

help: ## This help
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA-Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

.DEFAULT_GOAL := help

run-image: build-image ## Build docker compose file and start it
	echo "Project doesn't have docker image cause it is a library project"

stop-image: ## Stop the docker compose project
	echo "Project doesn't have docker image cause it is a library project"

build-image: build ## Build the docker image
	echo "Project doesn't have docker image cause it is a library project"

build: ## Build the application Artifact
	echo "Building jar"
ifeq ($(SKIP_TESTS),true)
	gradle build -x test
else
	gradle build
endif

unit-tests: ## Execute the unitary tests
	echo "Running unit tests"
	gradle test

integration-tests: ## Execute the integration tests
	echo "Running integration tests"

clean: ## Clean Project artifacts and directories
	echo "Cleaning artifacts"
	gradle clean

component-tests: ## Execute component test, to be implemented
	echo "TO BE IMPLEMENTED"

contract-tests: ## Execute contract test, to be implemented
	echo "TO BE IMPLEMENTED"

smoke-tests: ## Execute smoke test, to be implemented
	echo "TO BE IMPLEMENTED"

get-name: ## Get name for the application
	appname=$(shell cat $(SOURCE_PATH) | grep "^    <name>.*</name>$$" | awk -F'[->SNAPSHOT<]' '{print $$3}')

get-version: ## Get version for the application
	appversion=$(shell cat $(SOURCE_PATH) | grep "^    <version>.*</version>$$" | awk -F'[><]' '{print $$3}')
