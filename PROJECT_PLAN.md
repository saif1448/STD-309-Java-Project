# Boolean Logic Quiz Application - Project Plan

## Project Overview
A Java Swing application for teaching Boolean Logic with an introduction, study guide, and progressive quiz system.

## Application Flow
```
Introduction Page → Study Guide → Quiz Section
                                      ↓
                                 Easy Questions (15)
                                      ↓
                            Pass ≥75% → Medium Questions (10)
                            Fail <75% → Retry Easy (wrong answers)
                                      ↓
                            Pass ≥75% → Hard Questions (5)
                            Fail <75% → Retry Medium (wrong answers)
                                      ↓
                            Pass ≥75% → Completion Certificate
                            Fail <75% → Retry Hard (wrong answers)
```

## Implementation Steps

### Step 1: Project Structure & Core Classes
- **Files to Create:**
  - `QuizApp.java` - Main entry point with JFrame setup
  - `Question.java` - Already exists (add getters if needed)
  - `QuestionLoader.java` - Rename ApplicationStarter.java
  - `QuizState.java` - Track user progress, scores, current category

### Step 2: Introduction Page
- **Components:**
  - Title: "Introduction to Boolean Logic"
  - Welcome message with brief description
  - Attractive banner/header
  - "Start Learning" button → Study Guide
- **Design:**
  - Clean, centered layout
  - Professional color scheme (Blues/Greens for education)
  - Large, readable fonts

### Step 3: Study Guide Page
- **Components:**
  - Scrollable content area with Boolean Logic concepts
  - Topics: Boolean values, operators (AND, OR, NOT), comparisons
  - Code examples with syntax highlighting (colored text)
  - "Start Quiz" button → Quiz Section
  - "Back" button → Introduction
- **Design:**
  - Two-column layout or tabbed interface
  - Syntax-highlighted code blocks
  - Clear section headers

### Step 4: Quiz Section - Main Framework
- **Components:**
  - Question display area
  - 4 radio buttons for options (a, b, c, d)
  - Submit button
  - Progress indicator (Question X/Total)
  - Score display
  - Category indicator (Easy/Medium/Hard)
- **Logic:**
  - Load questions by category
  - Track correct/incorrect answers
  - Calculate percentage after category completion

### Step 5: Quiz Logic - Progressive System
- **Easy Category:**
  - Show all 15 easy questions
  - Calculate score: if ≥75% → unlock Medium
  - If <75% → show only incorrect questions again
- **Medium Category:**
  - Same logic as Easy
  - If ≥75% → unlock Hard
- **Hard Category:**
  - Final assessment
  - If ≥75% → Show completion certificate

### Step 6: Result & Retry System
- **Components:**
  - Result dialog after each category
  - Show score and percentage
  - "Continue" or "Retry Wrong Answers" buttons
  - Track which questions were answered incorrectly
- **Logic:**
  - Store incorrect question indices
  - Reload only failed questions for retry

### Step 7: UI Polish & Styling
- **Enhancements:**
  - Custom colors and fonts
  - Smooth transitions between pages
  - Icons/images for visual appeal
  - Responsive layout
  - Hover effects on buttons
  - Visual feedback (correct/incorrect indicators)

### Step 8: Final Testing & Refinements
- Test all navigation paths
- Test retry logic
- Test score calculations
- Polish UI inconsistencies

## Design Specifications

### Color Scheme
- **Primary:** #4A90E2 (Blue - Trust, Intelligence)
- **Secondary:** #50C878 (Emerald - Success)
- **Accent:** #FF6B6B (Coral - Attention)
- **Background:** #F5F7FA (Light Gray)
- **Text:** #2C3E50 (Dark Gray)

### Typography
- **Headers:** Arial Bold, 24-28px
- **Body:** Arial Regular, 14-16px
- **Code:** Courier New, 13px
- **Buttons:** Arial Bold, 14px

### Layout
- **Window Size:** 900x700 (resizable)
- **Padding:** 20-30px margins
- **Component Spacing:** 15-20px gaps

## Current Status
- ✅ Questions.csv formatted correctly (30 questions: 15 Easy, 10 Medium, 5 Hard)
- ✅ Question.java class exists
- ✅ ApplicationStarter.java (needs rename to QuestionLoader)
- ✅ Main.java (can be used for testing)

## Next Step
**Step 1:** Create core classes (QuizApp.java, QuizState.java, rename ApplicationStarter.java)

---

**Note:** After completing each step, we'll test and verify before moving to the next step.
