import java.awt.Color;
import java.awt.Graphics;

/*
Constrói uma árvore binária chamada heap e, em seguida, converte a heap em uma árvore binária completa.
Repetidamente remove o maior elemento (raiz) e reconstrói a heap até que toda a lista esteja ordenada.
*/

public class HeapSortPanel extends SortPanel {
   
    private static final long serialVersionUID = 1L;
    private int redColumn = -1;
    private int greenColumn = -1;
    private java.util.ArrayList<Integer> heap = new java.util.ArrayList<Integer>();

    public HeapSortPanel(String name, int sleepTime, int width, int height) {
        super(name, sleepTime, width, height);
    }

    @Override
    public void reset() {
        redColumn = -1;
        greenColumn = -1;
        heap.clear();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < list.length; i++) {
                add(list[i]);
                repaint();
                Thread.sleep(2 * sleepTime);
            }
            greenColumn = size;
            for (int i = list.length - 1; i >= 0; i--) {
                removeAndShow(i);
                repaint();
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {}
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
        int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
        for (int i = heap.size(); i < list.length; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
        }
        for (int i = 0; i < heap.size(); i++) {
            g.setColor(Color.GREEN);
            g.fillRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - heap.get(i) * columnHeight - 2 * BORDER_WIDTH, columnWidth, heap.get(i) * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - heap.get(i) * columnHeight - 2 * BORDER_WIDTH, columnWidth, heap.get(i) * columnHeight);
        }
        if (redColumn != -1) {
            g.setColor(Color.RED);
            g.fillRect(2 * BORDER_WIDTH + redColumn * columnWidth, getHeight() - heap.get(redColumn) * columnHeight - 2 * BORDER_WIDTH, columnWidth, heap.get(redColumn) * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + redColumn * columnWidth, getHeight() - heap.get(redColumn) * columnHeight - 2 * BORDER_WIDTH, columnWidth, heap.get(redColumn) * columnHeight);
        }
        if (greenColumn != -1) {
            for (int i = greenColumn; i < size; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
                g.setColor(Color.BLACK);
                g.drawRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
            }
        }
    }

    public void add(Integer newInteger) throws InterruptedException {
        heap.add(newInteger);
        repaint();
        Thread.sleep(3 * sleepTime);
        int currentIndex = heap.size() - 1;
        redColumn = currentIndex;
        while (currentIndex > 0) {
            repaint();
            Thread.sleep(3 * sleepTime);
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) > 0 ) {
                repaint();
                Thread.sleep(6 * sleepTime);
                int temp = heap.get(currentIndex);
                heap.set(currentIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
            } else {
                break;
            }
            currentIndex = parentIndex;
            redColumn = currentIndex;
        }
        redColumn = -1;
    }

    public void removeAndShow(int spyOnIndex) throws InterruptedException {
        if (heap.size() == 0) {
            return;
        }
        repaint();
        Thread.sleep(4 * sleepTime);
        Integer removedInteger = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        greenColumn--;
        list[spyOnIndex] = removedInteger;

        int currentIndex = 0;
        while (currentIndex < heap.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= heap.size()) {
                break;
            }
            int maxIndex = leftChildIndex;
            if (rightChildIndex < heap.size()) {
                repaint();
                Thread.sleep(4 * sleepTime);
                if (heap.get(maxIndex).compareTo(heap.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }
            if (heap.get(currentIndex).compareTo(heap.get(maxIndex)) < 0) {
                Integer temp = heap.get(maxIndex);
                heap.set(maxIndex, heap.get(currentIndex));
                heap.set(currentIndex, temp);
                currentIndex = maxIndex;
                repaint();
                Thread.sleep(4 * sleepTime);
            } else {
                break;
            }
        }
    }

}
