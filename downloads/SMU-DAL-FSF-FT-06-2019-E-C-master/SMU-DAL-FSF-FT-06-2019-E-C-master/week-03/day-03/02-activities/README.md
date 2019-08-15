# Cinder App

## Instructions

Work in GROUPS to complete all of the goals below.

The JSON demonstrates the type of data that the client expects. Create classes for each type. Use the JSON to determine the starting data that should go in your ArrayLists. Initialize this data in the Controller constructor.

**Step 1:** Create the following routes (it's okay if they return null to get started):
- `GET /api/match`
- `GET /api/profile`
- `POST /api/dislike`
- `PUT /api/profile`

**Step 2:**

Begin by returning all people when a GET request is made to `/api/match`

**Step 3:**
The POST `/api/dislike` route should add a new dislike to the dislikes ArrayList

**Step 4:**
Update your GET `/api/match` route such that it returns all people who are not in the dislike list.

**Step 5:**
The GET `/api/profile` route should return the profile. _(Note that we are hardcoding data for the current user. In a real application this id would be determined dynamically at login)_

**Step 6:**
The PUT `/api/profile` should update the profile. _(Note that we are hardcoding data for the current user. In a real application this id would be determined dynamically at login)_

**CHALLENGE**

Refactor the Profile such that it has a `personId` property which signifies the owner of this profile. Then create a profile for each user (use random/made up data).

Then, update the logic in your  GET `/api/match` route (this logic should really be in your service layer) to choose matches based on some threshold that you determine that measures similarity between your profile and theirs.