CREATE TABLE reflections(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    date DATE NOT NULL,
    mood TEXT CHECK ( mood IN ('good', 'neutral', 'tired', 'bad') ),
    user_note TEXT,
    ai_feedback TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE (user_id, date)
)