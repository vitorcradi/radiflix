#!/bin/bash

echo -e "$(date +%F\ %T.%N) \t ############ Starting MYSQL Server entrypoint..."

mysql --password=pass --user=user radiflix-db < /tmp/scripts/create-tables.sql