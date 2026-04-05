#!/usr/bin/env bash
set -euo pipefail

if [[ -z "${DERBY_HOME:-}" ]]; then
  echo "DERBY_HOME is not set."
  echo "Example: export DERBY_HOME=/absolute/path/to/db-derby-10.15.2.0-bin"
  exit 1
fi

host="${COURSE_SCHEDULER_DB_HOST:-localhost}"
port="${COURSE_SCHEDULER_DB_PORT:-1527}"

echo "Starting Derby network server on ${host}:${port}"
"${DERBY_HOME}/bin/startNetworkServer" -h "${host}" -p "${port}"
