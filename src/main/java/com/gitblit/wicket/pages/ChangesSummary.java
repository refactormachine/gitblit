package com.gitblit.wicket.pages;

import com.gitblit.models.TicketModel;

import java.util.ArrayList;
import java.util.List;

public class ChangesSummary {
    private final List<TicketModel.Change> revisions;
    private final List<TicketModel.Change> comments;
    private final List<TicketModel.Change> discussion;
    private final List<TicketModel.Change> statusChanges;

    public ChangesSummary(List<TicketModel.Change> revisions, List<TicketModel.Change> comments, List<TicketModel.Change> discussion, List<TicketModel.Change> statusChanges) {
        this.revisions = revisions;
        this.comments = comments;
        this.discussion = discussion;
        this.statusChanges = statusChanges;
    }

    public ChangesSummary(List<TicketModel.Change> changes) {
        revisions = new ArrayList<TicketModel.Change>();
        comments = new ArrayList<TicketModel.Change>();
        statusChanges = new ArrayList<TicketModel.Change>();
        discussion = new ArrayList<TicketModel.Change>();
        for (TicketModel.Change change : changes) {
            if (change.hasComment() || (change.isStatusChange() && (change.getStatus() != TicketModel.Status.New))) {
                discussion.add(change);
            }
            if (change.hasComment()) {
                comments.add(change);
            }
            if (change.hasPatchset()) {
                revisions.add(change);
            }
            if (change.isStatusChange() && !change.hasPatchset()) {
                statusChanges.add(change);
            }
        }
    }

    TicketModel.Change currentRevision() {
        return revisions.isEmpty() ? null : revisions.get(revisions.size() - 1);
    }

    public List<TicketModel.Change> getRevisions() {
        return revisions;
    }

    public List<TicketModel.Change> getComments() {
        return comments;
    }

    public List<TicketModel.Change> getDiscussion() {
        return discussion;
    }

    public List<TicketModel.Change> getStatusChanges() {
        return statusChanges;
    }
}
