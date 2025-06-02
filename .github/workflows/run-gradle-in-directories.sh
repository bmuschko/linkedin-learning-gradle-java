#!/usr/bin/env bash
set -euo pipefail

if ((BASH_VERSINFO[0] < 4)); then
  echo "This script requires Bash 4+."
  exit 1
fi

if [ $# -ne 1 ]; then
  echo "Usage: $0 'dir1=task1 dir2=task2 ...'"
  exit 1
fi

TASKS_STRING="$1"
declare -A dir_tasks

# Parse key=value pairs into associative array
for pair in $TASKS_STRING; do
  IFS='=' read -r dir task <<< "$pair"
  dir_tasks["$dir"]="$task"
done

# Run each Gradle task
for dir in "${!dir_tasks[@]}"; do
  task="${dir_tasks[$dir]}"
  echo "➡️ Running Gradle task '$task' in '$dir'"
  (cd "$dir" && gradle $task --warning-mode fail)
done
