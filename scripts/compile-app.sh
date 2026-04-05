#!/usr/bin/env bash
set -euo pipefail

script_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
repo_root="$(cd "${script_dir}/.." && pwd)"
project_dir="${repo_root}/CourseSchedulerVayunandanreddyPannalaVFP5175"
output_dir="${project_dir}/build-cli"

mkdir -p "${output_dir}"
echo "Compiling source files into ${output_dir}"
javac -d "${output_dir}" "${project_dir}"/src/*.java
echo "Compilation complete."
