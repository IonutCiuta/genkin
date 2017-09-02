#!/bin/bash

#init the database with some initial data, e.g. categories
mongoimport --db genkin --collection categories --drop --file categories.json