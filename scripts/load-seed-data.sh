#!/usr/bin/env bash
set -euo pipefail

if [[ -z "${DERBY_HOME:-}" ]]; then
  echo "DERBY_HOME is not set."
  echo "Example: export DERBY_HOME=/absolute/path/to/db-derby-10.15.2.0-bin"
  exit 1
fi

script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo_root="$(cd "${script_dir}/.." && pwd)"

host="${COURSE_SCHEDULER_DB_HOST:-localhost}"
port="${COURSE_SCHEDULER_DB_PORT:-1527}"
db_name="${COURSE_SCHEDULER_DB_NAME:-CourseSchedulerDBVayunandanreddyPannalaVFP5175}"

ij_file="$(mktemp)"
trap 'rm -f "${ij_file}"' EXIT

cat > "${ij_file}" <<EOF
connect 'jdbc:derby://${host}:${port}/${db_name}';
run '${repo_root}/database/seed.sql';
exit;
EOF

echo "Loading demo seed data into ${db_name} on ${host}:${port}"
"${DERBY_HOME}/bin/ij" "${ij_file}"
echo "Seed data load complete."
