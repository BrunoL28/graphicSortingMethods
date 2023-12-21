import java.awt.Color;
import java.awt.Graphics;

/*
Divide a lista em uma parte ordenada e outra não ordenada.
Encontra o menor elemento na parte não ordenada e o coloca no 
final da parte ordenada, repetindo esse processo.
*/

public class SelectionSortPanel extends SortPanel {
    
    private static final long serialVersionUID = 1L;
    private int redColumn = -1;
    private int blueColumn = -1;
    private int greenColumn = -1;

    public SelectionSortPanel(String name, int sleepTime, int width, int height) {
        super(name, sleepTime, width, height);
    }

    @Override
    public void reset() {
        redColumn = -1;
        blueColumn = -1;
        greenColumn = -1;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < list.length - 1; i++) {
                int currentMin = i;
                redColumn = currentMin;
                for (int j = i + 1; j < list.length; j++) {
                    blueColumn = j;
                    repaint();
                    Thread.sleep(4 * sleepTime);
                    if (list[currentMin] > list[j]) {
                        currentMin = j;
                        redColumn = currentMin;
                        repaint();
                    }
                }
                if (currentMin != i) {
                    int temp = list[currentMin];
                    list[currentMin] = list[i];
                    list[i] = temp;
                    repaint();
                    Thread.sleep(4 * sleepTime);
                }
                greenColumn++;
                repaint();
            }
            greenColumn++;
            redColumn = -1;
            blueColumn = -1;
        } catch (InterruptedException e) {}
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int columnWidth = (getWidth() - 4 * BORDER_WIDTH) / size;
        int columnHeight = (getHeight() - 4 * BORDER_WIDTH) / size;
        for (int i = (greenColumn == -1 ? 0 : greenColumn); i < list.length; i++) {
            g.setColor(Color.WHITE);
            g.fillRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
        }
        for (int i = 0; i <= greenColumn; i++) {
            g.setColor(Color.GREEN);
            g.fillRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + i * columnWidth, getHeight() - list[i] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[i] * columnHeight);
        }
        if (redColumn != -1) {
            g.setColor(Color.RED);
            g.fillRect(2 * BORDER_WIDTH + redColumn * columnWidth, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + redColumn * columnWidth, getHeight() - list[redColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[redColumn] * columnHeight);
        }
        if (blueColumn != -1) {
            g.setColor(Color.BLUE);
            g.fillRect(2 * BORDER_WIDTH + blueColumn * columnWidth, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
            g.setColor(Color.BLACK);
            g.drawRect(2 * BORDER_WIDTH + blueColumn * columnWidth, getHeight() - list[blueColumn] * columnHeight - 2 * BORDER_WIDTH, columnWidth, list[blueColumn] * columnHeight);
        }
    }

}
