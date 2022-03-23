# USE CASE: 22 The top N populated capital cities in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

We want to **produce a report on the top N populated capital cities in a continent where N is provided by the user.**

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains city data, country data and has country continent field filled.

### Success End Condition

A report is produced successfully and correctly

### Failed End Condition

No report is produced or is incorrect.

### Primary Actor

User.

### Trigger

A request for information is sent.

## MAIN SUCCESS SCENARIO

1. Request city information, supply N.
2. Extracts current information of all cities in the database where the City is a capital city and the country is in the given continent.
3. Limit responses to N.
4. Report produced.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.4
