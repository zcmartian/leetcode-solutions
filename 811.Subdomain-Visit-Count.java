class Solution {
    public List<String> subdomainVisits(String[] cpdomains) 
    {
        Map<String,Integer> domainCount = new HashMap<>();

        List<String> result = new ArrayList<>();

        for(String cpdomain : cpdomains)
        {
            String[] separateCountAndDomain = cpdomain.split(" ");

            int count = Integer.parseInt(separateCountAndDomain[0]);

            String domain = separateCountAndDomain[1];

            while(true)
            {
                if(!domainCount.containsKey(domain))
                {
                    domainCount.put(domain,count);
                }
                else
                {
                    domainCount.put(domain,domainCount.get(domain) + count);
                }

                int indexOfDot = domain.indexOf(".");
                if(indexOfDot == -1) break;
                domain = domain.substring(indexOfDot+1,domain.length());
            }
        }

        for(Map.Entry<String,Integer> entry : domainCount.entrySet())
        {
            String item = entry.getValue() + " " + entry.getKey();
            result.add(item);
        }

        return result;
    }
}
