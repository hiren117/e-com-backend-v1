# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Spring Boot 3.4.12 (Java 17) backend for a full-stack e-commerce app. The companion React frontend lives in the sibling `e-com-frontend/` repo and runs on `http://localhost:5173`.

## Commands

**Run:**
```bash
./mvnw spring-boot:run
```

**Build JAR:**
```bash
./mvnw clean package
```

**Run tests:**
```bash
./mvnw test
# Single test class:
./mvnw test -Dtest=EcommerceBackendApplicationTests
```

**Database:** PostgreSQL on `localhost:5432`, database `ecom_kashima`, user `postgres`. Hibernate DDL is set to `update` (auto-migrates on startup).

**Server port:** `1090`

## Architecture

Package root: `com.kashima.ecom_backend`

- `config/` — Spring Security (`AppConfig`), JWT generation/validation (`JwtProvider`, `JwtValidator`, `JwtConstant`)
- `controller/` — REST controllers
- `service/` — Interface + `Impl` pairs for all domain logic
- `repository/` — Spring Data JPA repositories
- `model/` — JPA entities
- `request/` / `response/` — DTO classes
- `exception/` — domain-specific exceptions

**Security:** Stateless JWT via Spring Security. Routes under `/api/**` require a valid JWT in the `Authorization: Bearer <token>` header. Routes under `/auth/**` are public. Admin endpoints live under `/api/admin/**`.

**JWT:** Token is signed with the secret in `JwtConstant.SECRET_KEY` and encodes the user's email as the `email` claim. Expires in ~9.8 days.

**Auth flow:** `POST /auth/signup` and `POST /auth/signin` both return `{ jwt, message }`. On signup, an empty `Cart` is created for the new user.

## Git workflow (WSL/Windows quirk)

This repo lives on the Windows filesystem (`/mnt/c/...`), so git has two limitations when run from WSL:

1. **`git config` writes fail** — use `-c` flags inline instead:
   ```bash
   git -c user.name="hiren117" -c user.email="hirensolanki9697@gmail.com" commit -m "..."
   ```
2. **Push requires interactive credentials** — hand off to the terminal:
   ```
   ! git push
   ```
