

# shellcheck disable=SC2046
export $(cat .env | xargs)

echo "DB NAME: ${DB_NAME}"