#!/usr/bin/env bash

clj -T:build uberjar
native-image --features=clj_easy.graal_build_time.InitClojureClasses -jar target/app.jar target/app