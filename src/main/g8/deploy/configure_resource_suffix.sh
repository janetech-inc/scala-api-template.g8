#!/usr/bin/env bash

# Exit script if you try to use an uninitialized variable.
set -o nounset

# Exit script if a statement returns a non-true return value.
set -o errexit

# Use the error status of the first failure, rather than that of the last item in a pipeline.
set -o pipefail

export_suffix() {
  echo "export AWS_RESOURCE_NAME_SUFFIX=$1" >> $BASH_ENV
}

case "$CIRCLE_BRANCH" in
"master")
  export_suffix "int"
  ;;
"staging")
  export_suffix "stage"
  ;;
"production")
  export_suffix "prod"
  ;;
*)
  export_suffix "sandbox"
  ;;
esac