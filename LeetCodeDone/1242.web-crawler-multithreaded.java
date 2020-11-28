/*
* @lc app=leetcode id=1242 lang=java
*
* [1242] Web Crawler Multithreaded
*/
import java.util.*;
import java.util.concurrent.*;
// @lc code=start
/**
 * // This is the HtmlParser's API interface. // You should not implement it, or
 * speculate about its implementation interface HtmlParser { public List<String>
 * getUrls(String url) {} }
 */

class Solution {
  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
    String hostname = getHostname(startUrl);
    Set<String> visited = new HashSet<>();
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    queue.offer(startUrl);
    ExecutorService executor = Executors.newFixedThreadPool(4, runnable -> {
      Thread thread = new Thread(runnable);
      // thread.setDaemon(true);
      return thread;
    });
    Deque<Future> tasks = new ArrayDeque<>();
    while (true) {
      String cur = queue.poll();
      if (cur != null) {
        if (getHostname(cur).equals(hostname) && !visited.contains(cur)) {
          visited.add(cur);
          tasks.add(executor.submit(() -> {
            List<String> nextUrls = htmlParser.getUrls(cur);
            for (String nextUrl: nextUrls) {
              queue.offer(nextUrl);
            }
          }));
        }
      } else {
        if (!tasks.isEmpty()) {
          Future task = tasks.poll();
          try {
            task.get();
          } catch (Exception e){ //(InterruptedException | ExecutionException e) {
  
          }
        } else {
          break;
        }
      }
    }
    executor.shutdownNow();
    return new ArrayList<String>(visited);
  }
  private String getHostname(String startUrl) {
    int endIdx = startUrl.indexOf("/", 7);
    return endIdx == -1 ? startUrl: startUrl.substring(0, endIdx);
  }
}
// @lc code=end
