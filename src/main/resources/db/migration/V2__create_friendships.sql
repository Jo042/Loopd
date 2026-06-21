CREATE TABLE friendships (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    requester_id UUID REFERENCES users(id) ON DELETE CASCADE,
    addressee_id UUID REFERENCES users(id) ON DELETE CASCADE,
    status TEXT DEFAULT 'pending' CHECK ( status IN ('pending', 'accepted') ),
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE (requester_id, addressee_id)
);