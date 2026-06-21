CREATE TABLE goals (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    parent_goal_id UUID REFERENCES goals(id) ON DELETE SET NULL,
    level TEXT NOT NULL CHECK (level IN ('yearly', 'quarterly', 'monthly', 'weekly')),
    title TEXT NOT NULL,
    description TEXT,
    start_date DATE,
    end_date DATE,
    status TEXT DEFAULT 'active' CHECK (status IN ('active', 'completed', 'archived')),
    created_at TIMESTAMP DEFAULT NOW()
);