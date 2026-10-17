package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final List<String> items = new ArrayList<>();
    private final List<Boolean> doneFlags = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
                doneFlags.add(false);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            doneFlags.remove(index);
            return true;
        }
        return false;
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            doneFlags.set(index, true);
            return true;
        }
        return false;
    }

    public boolean isDone(int index) {
        return index >= 0 && index < doneFlags.size() && doneFlags.get(index);
    }

    public void clear() {
        items.clear();
        doneFlags.clear();
    }

    public List<String> search(String query) {
        List<String> result = new ArrayList<>();
        if (query == null || query.isBlank()) {
            return result;
        }
        String lowerQuery = query.trim().toLowerCase();
        for (String item : items) {
            if (item.toLowerCase().contains(lowerQuery)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}