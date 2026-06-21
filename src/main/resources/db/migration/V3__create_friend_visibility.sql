CREATE TABLE friend_visibility(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    friend_id UUID REFERENCES users(id) ON DELETE CASCADE,
    can_see_goals BOOLEAN DEFAULT FALSE,
    can_see_routines BOOLEAN DEFAULT FALSE,
    can_see_tasks BOOLEAN DEFAULT FALSE,
    UNIQUE (user_id, friend_id)
);
