# USE CASE: 21 The top N populated capital cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

We want to **produce a report on the top N populated capital cities in the world where N is provided by the user.**

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains city data and country data.

### Success End Condition

A report is produced successfully and correctly

### Failed End Condition

No report is produced or is incorrect.

### Primary Actor

User.

### Trigger

A request for information is sent.

## MAIN SUCCESS SCENARIO

1. Request city information, Supply N.
2. Extracts current information of all cities in the database where the city is a countrys capital city.
3. Limit responses to N.
4. Report produced.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.4
