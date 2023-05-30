private void cancelAcquire(Node node) {        // Ignore if node doesn't exist        if (node == null)            return;        node.thread = null;        // Skip cancelled predecessors        Node pred = node.prev;        while (pred.waitStatus > 0)            node.prev = pred = pred.prev;        // predNext is the apparent node to unsplice. CASes below will        // fail if not, in which case, we lost race vs another cancel        // or signal, so no further action is necessary, although with        // a possibility that a cancelled node may transiently remain        // reachable.        Node predNext = pred.next;        // Can use unconditional write instead of CAS here.        // After this atomic step, other Nodes can skip past us.        // Before, we are free of interference from other threads.        node.waitStatus = Node.CANCELLED;        // If we are the tail, remove ourselves.        if (node == tail && compareAndSetTail(node, pred)) {            pred.compareAndSetNext(predNext, null);        } else {            // If successor needs signal, try to set pred's next-link            // so it will get one. Otherwise wake it up to propagate.            int ws;            if (pred != head &&                ((ws = pred.waitStatus) == Node.SIGNAL ||                 (ws <= 0 && pred.compareAndSetWaitStatus(ws, Node.SIGNAL))) &&                pred.thread != null) {                Node next = node.next;                if (next != null && next.waitStatus <= 0)                    pred.compareAndSetNext(predNext, next);            } else {                unparkSuccessor(node);            }            node.next = node; // help GC  !!!!CONFUSE ME!!!!        }    }