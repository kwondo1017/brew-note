# Security Checklist

When reviewing code, check the following basic security items.

## 1. Input Validation
- Verify that all external inputs (request body, query parameters, path variables) are validated appropriately.
- Check whether invalid, null, empty, or out-of-range values are handled safely.
- Prefer using explicit validation annotations or clear validation logic instead of assuming valid input.

## 2. Authentication and Authorization
- Check whether endpoints that should be protected require proper authentication.
- Check whether the code enforces authorization, not just authentication.
- Verify that users cannot access, modify, or delete resources that belong to other users without permission.

## 3. Sensitive Information Exposure
- Do not expose passwords, tokens, secrets, API keys, or internal configuration values in code, logs, responses, or error messages.
- Avoid returning unnecessary internal information such as database details, stack traces, or server implementation details to clients.

## 4. Logging Safety
- Check that logs do not contain sensitive personal information, credentials, tokens, or secret values.
- Ensure that error logs are useful for developers but do not leak sensitive runtime information.

## 5. SQL Injection and Query Safety
- Check that database queries are written safely and do not concatenate untrusted input directly into SQL or JPQL strings.
- Prefer parameterized queries, prepared statements, or framework-supported safe query methods.

## 6. File and Path Handling
- If the code handles file upload/download or file paths, verify that it does not trust user-provided filenames or paths directly.
- Check for risks such as path traversal, arbitrary file overwrite, or unsafe file type handling.

## 7. External API and Secret Handling
- Check that API keys, passwords, tokens, and credentials are not hardcoded.
- Verify that secrets are loaded from secure configuration or environment variables.
- Do not expose external service credentials in test code or sample code.

## 8. Error Handling
- Check whether exceptions are handled in a controlled way.
- Avoid exposing raw exception messages directly to clients.
- Prefer consistent error responses that reveal only necessary information.

## 9. Unsafe Defaults
- Check whether default settings are too permissive.
- Be cautious when code allows all access, disables validation, skips checks, or uses broad wildcard configuration without clear reason.

## 10. Data Integrity and Ownership
- Check whether update/delete operations verify the target resource correctly before changing it.
- Ensure that important business data cannot be modified in unintended ways due to missing ownership checks or missing state validation.

## 11. Serialization and Response Safety
- Check that response objects do not expose unnecessary fields.
- Be careful not to return internal entity structures directly when they may contain sensitive or unintended data.

## 12. General Review Principle
- If something looks convenient but bypasses validation, authorization, or safety checks, treat it as suspicious.
- Prefer explicit and readable security-related logic over implicit behavior.

## 13. JPA and Entity Safety
- Be careful when exposing JPA entities directly in API responses.
- Check whether cascading, orphanRemoval, and bidirectional relationships can cause unintended updates or deletes.

## 14. Mass Assignment Risk
- Check whether request data can modify fields that should not be changed by clients.
- Prefer explicit request DTO mapping instead of binding client input directly to entities.