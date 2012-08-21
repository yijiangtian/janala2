/*
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 */

package database.table;

import junit.framework.TestCase;

/**
 * Author: Koushik Sen (ksen@cs.berkeley.edu)
 * Date: 8/21/12
 * Time: 10:37 PM
 */
public class SelectCommandTest extends TestCase {
    private Table customers;

    public void setUp() throws Exception {
        customers = TableFactory.create("Customers", new String[] { "Id",
				"Name", "PasswordHash", "Age" }, new int[] { Table.INT,
				Table.STRING, Table.INT, Table.INT }, new boolean[] { true,
				false, false, false }, new ForeignKey[] { null, null, null,
				null });
        customers.insert(new Object[]{1,"A",12,23});
        customers.insert(new Object[]{2,"A",13,23});
        customers.insert(new Object[]{7,"C",19,24});
        customers.insert(new Object[]{4,"D",11,24});
        customers.insert(new Object[]{3,"E",10,23});

    }

    public void tearDown() throws Exception {

    }

    public void testExecute() throws Exception {

    }

    public void testSelect1() throws Exception {
        Table t = (new SelectCommand(
                new Select() {
                    public String[] selectAs() {
                        return new String[]{"Id","Age"};
                    }

                    public Operations[] select() {
                        return new Operations[]{new ProjectOperation("Id"), new ProjectOperation("Age")};
                    }
                },
                new From(new Table[]{customers}),
                new Where() {

                    @Override
                    public boolean isTrue(Row[] rows) {
                        return false;  //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public boolean where(Row[] rows) {
                        Integer i = (Integer) rows[0].get("PasswordHash");
                        return (i!=null && i > 10);
                    }

                },
                new GroupBy() {
                    int i = 0;
                    public Object[] groupBy(Row[] rows) {
                        i++;
                        return new Object[] {i};
                    }
                },
                new Having(),
                null, false
        )).execute();
        assertEquals(4,t.size());
        TableIterator iter = t.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
    }

    public void testSelectDistinct() throws Exception {
        Table t = (new SelectCommand(
                new Select() {
                    public String[] selectAs() {
                        return new String[]{"Name","Age"};
                    }

                    public Operations[] select() {
                        return new Operations[]{new ProjectOperation("Name"), new ProjectOperation("Age")};
                    }
                },
                new From(new Table[]{customers}),
                new Where() {

                    @Override
                    public boolean isTrue(Row[] rows) {
                        return false;  //To change body of implemented methods use File | Settings | File Templates.
                    }

                    @Override
                    public boolean where(Row[] rows) {
                        Integer i = (Integer) rows[0].get("PasswordHash");
                        return (i!=null && i > 10);
                    }

                },
                new GroupBy() {
                    int i = 0;
                    public Object[] groupBy(Row[] rows) {
                        i++;
                        return new Object[] {i};
                    }
                },
                new Having(),
                null, true
        )).execute();
        TableIterator iter = t.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        assertEquals(3,t.size());
    }
}
