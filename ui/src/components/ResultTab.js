export const ResultTab = ({ searchQuery, frequency, similarWords }) => (
  <>
    <div>
      <h4>
        Showing results for <b>{searchQuery}</b>
      </h4>
      <p>Frequency : {frequency}</p>
      <p>
        Similar Words :{" "}
        {similarWords.length ? similarWords : "Not Found"}
      </p>
    </div>
  </>
);
