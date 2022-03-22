# USE CASE: 5 Produce a Report on the top N populated countries in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

We want to **produce a Report on the top N populated countries in the world where N is provided by the user.**

### Scope

World.

### Level

Primary task.

### Preconditions

Database contains country data.
N provided by the user.

### Success End Condition

A report is produced successfully and correctly

### Failed End Condition

No report is produced or is incorrect.

### Primary Actor

User.

### Trigger

A request for information is sent.

## MAIN SUCCESS SCENARIO

1. Request population information from country and supply a limit.
2. Extracts current information of all countries in the world sorted by population.
3. limit responses to top N countries.
4. Report produced.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 0.2
