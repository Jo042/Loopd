CREATE TABLE tasks (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    goal_id UUID REFERENCES goals(id) ON DELETE SET NULL,
    title TEXT NOT NULL,
    recurrence TEXT,
    source TEXT NOT NULL CHECK (source IN ('ai_suggestion', 'manual', 'post_add')),
    due_date DATE,
    status TEXT DEFAULT 'todo' CHECK (status IN ('todo', 'done', 'skipped')),
    is_template BOOLEAN DEFAULT FALSE,
    declared_at TIMESTAMP,
    completed_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW()
);