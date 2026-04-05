#!/usr/bin/env bash
set -euo pipefail

script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo_root="$(cd "${script_dir}/.." && pwd)"
project_dir="${repo_root}/CourseSchedulerVayunandanreddyPannalaVFP5175"

"${script_dir}/compile-app.sh"

classpath="${project_dir}/build-cli"
if [[ -n "${DERBY_HOME:-}" && -f "${DERBY_HOME}/lib/derbyclient.jar" ]]; then
  classpath="${classpath}:${DERBY_HOME}/lib/derbyclient.jar"
fi

echo "Launching Course Scheduler..."
java -cp "${classpath}" MainFrame
