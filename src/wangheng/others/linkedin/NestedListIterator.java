package wangheng.others.linkedin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class NestedListIterator2 {
    Stack<Iterator<Element>> st;
    Integer next;

    public NestedListIterator2(Element ele) {
        st = new Stack<Iterator<Element>>();

        if (ele.isNum())
            next = ele.getInt();
        else {
            st.push(ele.getList().iterator());
            moveToNext();
        }
    }

    private void moveToNext() {
        next = null;
        while (!st.isEmpty()) {
            Iterator<Element> it = st.peek();
            if (it.hasNext()) {
                Element o = it.next();
                if (o.isNum()) {
                    next = o.getInt();
                    break;
                } else {
                    st.push(o.getList().iterator());
                }
            } else {
                st.pop();
            }
        }
    }

    public boolean hasNext() {
        return next != null;
    }

    public Integer next() {
        if (next == null)
            throw new RuntimeException("iterator ended!");
        int res = next;
        moveToNext();
        return res;
    }

}

public class NestedListIterator {

    public static void main(String[] args) {
        Element ele = new Element(1);
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] {}));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] { new Element(1) }));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] { new Element(1), new Element(2) }));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] { new Element(1), new Element(2),
                new Element(Arrays.asList(new Element[] { new Element(3), new Element(4) })) }));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] {
                new Element(1),
                new Element(2),
                new Element(Arrays.asList(new Element[] {
                        new Element(3),
                        new Element(4),
                        new Element(Arrays.asList(new Element[] { new Element(5), new Element(6),
                                new Element(Arrays.asList(new Element[] { new Element(7), new Element(8) })) })) })) }));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] {
                new Element(Arrays.asList(new Element[] {})),
                new Element(Arrays.asList(new Element[] {})),
                new Element(Arrays.asList(new Element[] { new Element(Arrays.asList(new Element[] {})),
                        new Element(Arrays.asList(new Element[] {})) })) }));
        iterate(ele);

        ele = new Element(Arrays.asList(new Element[] {
                new Element(Arrays.asList(new Element[] {})),
                new Element(Arrays.asList(new Element[] { new Element(1) })),
                new Element(Arrays.asList(new Element[] { new Element(Arrays.asList(new Element[] { new Element(2) })),
                        new Element(Arrays.asList(new Element[] {})) })) }));
        iterate(ele);
    }

    public static void iterate(Element ele) {
        NestedListIterator2 ite = new NestedListIterator2(ele);
        while (ite.hasNext()) {
            System.out.print(ite.next() + " ");
        }
        System.out.println();
    }

    Stack<EleAndPos> stack;

    public NestedListIterator(Element ele) {
        stack = new Stack<EleAndPos>();
        if (ele.isNum() || !ele.getList().isEmpty()) {
            EleAndPos root = new EleAndPos(new Element(Arrays.asList(new Element[] { new Element(0), ele })));
            stack.push(root);
            moveToNext();
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        if (stack.isEmpty())
            throw new RuntimeException("iterator ended!");
        int res = stack.pop().ele.getInt();
        moveToNext();
        return res;
    }

    private void moveToNext() {
        if (stack.isEmpty())
            return;

        EleAndPos elePos = stack.peek();
        elePos.pos++;

        while (elePos != null && elePos.pos == elePos.ele.getList().size()) {
            stack.pop();

            if (stack.isEmpty())
                return;

            elePos = stack.peek();
            elePos.pos++;
        }

        Element ele = elePos.ele.getList().get(elePos.pos);
        while (!ele.isNum()) {
            if (ele.getList().size() == 0) {
                ele = null;
                break;
            }

            elePos = new EleAndPos(ele);
            stack.push(elePos);

            ele = ele.getList().get(0);
        }

        if (ele == null) {
            moveToNext();
            return;
        }

        stack.push(new EleAndPos(ele));
    }
}

class Element {
    private List<Element> list;
    private int num;

    Element(List<Element> list) {
        this.list = list;
    }

    Element(int num) {
        this.num = num;
    }

    boolean isNum() {
        return list == null;
    }

    int getInt() {
        return num;
    }

    List<Element> getList() {
        return list;
    }
}

class EleAndPos {
    Element ele;
    int pos;

    EleAndPos(Element ele) {
        this(ele, 0);
    }

    EleAndPos(Element ele, int pos) {
        this.ele = ele;
        this.pos = pos;
    }
}
